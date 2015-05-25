package com.itzgud.iride.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import com.itzgud.iride.model.PersistentEntity;

public class ReflectionsUtils {

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public @interface Exclude {

	}

	public interface Copyable {

	}

	public static class ReflectionCopyException extends RuntimeException {

		public ReflectionCopyException(Exception ex) {

			super(ex);

		}

		public ReflectionCopyException(String message) {

			super(message);

		}

	}

	/**
	 * 
	 * Copies data from one object to another
	 * 
	 * Source/target objects must be of the same class, which must implement the
	 * Copyable interface
	 * 
	 * Any field annotated with @ExcludeFromReflectionCopy will not be copied
	 */

	public static <T extends Copyable> void copy(T sourceObj, T destinationObj) {

		if (sourceObj.getClass() != destinationObj.getClass()) {

			throw new ReflectionCopyException(
					"Source and destination objects should be in the same type");

		}

		try {

			Class sourceClass = sourceObj.getClass();

			do {

				for (Field field : sourceClass.getDeclaredFields()) {

					if (field.getAnnotation(Exclude.class) == null
							&& !java.lang.reflect.Modifier.isStatic(field
									.getModifiers())) {

						field.setAccessible(true);

						field.set(destinationObj, field.get(sourceObj));

					}

				}

				sourceClass = sourceClass.getSuperclass();

			} while (sourceClass != PersistentEntity.class);

		}

		catch (IllegalAccessException ex) {

			throw new ReflectionCopyException(ex);

		}

	}

}