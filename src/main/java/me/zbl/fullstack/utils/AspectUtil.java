package me.zbl.fullstack.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Section operation tool
 *
 * @author raviteja bollimuntha
 */
public class AspectUtil {

  /**
   * Get a comment on the type of connection point
   *
   * @param joinPoint Connection point
   * @param clazz     Annotation classes
   *
   * @return Comments
   */
  public static Annotation getAnnotation(ProceedingJoinPoint joinPoint, Class clazz) {
    try {
      // Intercepted object
      Object object = joinPoint.getTarget();
      Signature signature = joinPoint.getSignature();
      // Intercept method name
      String methodName = signature.getName();
      Class[] parameterTypes = ((MethodSignature) signature).getMethod().getParameterTypes();

      try {
        //  reflection target method
        Method method = object.getClass().getDeclaredMethod(methodName, parameterTypes);
        // Get annotations
        return method.getDeclaredAnnotation(clazz);
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      }
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
    return null;
  }
}
