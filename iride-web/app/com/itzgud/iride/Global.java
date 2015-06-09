package com.itzgud.iride;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.code.morphia.Morphia;
import com.itzgud.iride.framework.MorphiaObject;
import com.itzgud.iride.framework.error.ErrorManager;
import com.mongodb.Mongo;

import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.Play;
import play.api.mvc.EssentialFilter;
import play.filters.gzip.GzipFilter;
import play.libs.F;
import play.mvc.Http;
import play.mvc.Result;

import java.io.File;
import java.net.UnknownHostException;

/**
 * 
 * Application wide behaviour. We establish a Spring application context for the
 * dependency injection system and
 * 
 * configure Spring Data.
 */

public class Global extends GlobalSettings {

	/**
	 * 
	 * Declare the application context to be used - a Java annotation based
	 * application context requiring no XML.
	 */

	private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

	private ErrorManager errorManager;

	private ErrorManager getErrorManager() {

		if (errorManager == null) {

			errorManager = context.getBean(ErrorManager.class);

		}

		return errorManager;

	}

	/**
	 * 
	 * Sync the context lifecycle with Play's.
	 */

	@Override
	public void onStart(final Application app) {

		super.onStart(app);

		// AnnotationConfigApplicationContext can only be refreshed once, but we
		// do it here even though this method

		// can be called multiple times. The reason for doing during startup is
		// so that the Play configuration is

		// entirely available to this application context.

		context.register(com.itzgud.iride.Config.class);
		context.scan(
				"com.itzgud.iride.dao",
				"com.itzgud.iride.dto",
				"com.itzgud.iride.model",
				"com.itzgud.iride.framework",
				"com.itzgud.iride.services",
				"com.itzgud.iride.util",
				"com.itzgud.iride.controllers"
				);
		context.refresh();

		// This will construct the beans and call any construction lifecycle
		// methods e.g. @PostConstruct

		context.start();

		//Initiate MongoDB
		
		initiateMongoDB();
		
		// Start the Grunt build tool

		/*if (Play.isProd()) {

			GruntBuilder.build();

		} else {

			GruntBuilder.startWatch();

		}*/

	}
	
	private void initiateMongoDB(){
		 Logger.debug("** onStart initiateMongoDB**"); 
		    try {
		      MorphiaObject.mongo = new Mongo("127.0.0.1", 27017);
		    } catch (UnknownHostException e) {
		      e.printStackTrace();
		    }
		    MorphiaObject.morphia = new Morphia();
		    MorphiaObject.datastore = MorphiaObject.morphia.createDatastore(MorphiaObject.mongo, "iridemongodb");
		    MorphiaObject.datastore.ensureIndexes();   
		    MorphiaObject.datastore.ensureCaps();  

		    Logger.debug("** Morphia datastore: " + MorphiaObject.datastore.getDB());
	}

	/**
	 * 
	 * Sync the context lifecycle with Play's.
	 */

	@Override
	public void onStop(final Application app) {

		// Stop the Grunt build tool

		/*if (!Play.isProd()) {

			GruntBuilder.endWatch();

		}*/

		// This will call any destruction lifecycle methods and then release the
		// beans e.g. @PreDestroy

		context.close();

		
		super.onStop(app);

	}

	@Override
	public F.Promise<Result> onError(Http.RequestHeader request,
			Throwable t) {

		return getErrorManager().handle(request, t);

	}

	/**
	 * 
	 * Controllers must be resolved through the application context. There is a
	 * special method of GlobalSettings
	 * 
	 * that we can override to resolve a given controller. This resolution is
	 * required by the Play router.
	 */

	@Override
	public <A> A getControllerInstance(Class<A> aClass) {

		return context.getBean(aClass);

	}

	public <T extends EssentialFilter> Class<T>[] filters() {

		return new Class[] { GzipFilter.class };

	}

	
}