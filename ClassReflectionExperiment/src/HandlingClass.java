import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HandlingClass {

	public void handle(Object object, String methodName) {
		Class<? extends Object> theClass = object.getClass();
		Method[] methods = theClass.getMethods();

		for(Method method : methods) {
			String mName = method.getName();
			System.out.println(mName);
			if(mName.equals(methodName)) {
				Class<? extends Object>[] parameterTypes = method.getParameterTypes();
				Object[] parameters = new Object[parameterTypes.length];
				int idx = 0;
				for(Class<? extends Object> parType : parameterTypes) {
					if(parType.equals(String.class)) {
						parameters[idx] = "Hello";
					}
					else if(parType.equals(int.class)) {
						int defaultInt = 4;
						parameters[idx] = defaultInt;
					}
					else if(parType.equals(Integer.class)){
					    	parameters[idx] = Integer.valueOf(4);					    	
					}
					else
						parameters[idx] = null;
					idx ++;
				}
				
				try {
					method.invoke(object, parameters);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}

			}
		}
	}

}
