/**
 * 
 */
package com.github.walterfan.gtd.model;

/**
 * Base class for Model objects. Inherited class should implement toString(), 
 * equals() and hashCode();
 *
 */
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The Class BaseObject.
 *
 * @author yafan
 */
public abstract class BaseObject implements Serializable {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the field.
     *
     * @param strField the str field
     * @return the field
     * @throws IllegalAccessException the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws NoSuchMethodException the no such method exception
     */
    public Object getField(String strField) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {
        return PropertyUtils.getProperty(this, strField);
    }

    /**
     * Invoke method.
     *
     * @param strMethod the str method
     * @param args the args
     * @return the object
     * @throws IllegalArgumentException the illegal argument exception
     * @throws IllegalAccessException the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws SecurityException the security exception
     * @throws NoSuchMethodException the no such method exception
     */
    public Object invokeMethod(String strMethod, Object... args)
            throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, SecurityException, NoSuchMethodException {
        Method method = this.getClass().getMethod(strMethod, (Class<?>) null);
        return method.invoke(this, args);
    }

    /**
     * Read string.
     *
     * @param in the in
     * @param len the len
     * @return the string
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected String readString(ObjectInput in, int len) throws IOException {
        if (len > 0) {
            byte[] bytes = new byte[len];
            in.read(bytes, 0, len);
            return new String(bytes);
        } else {
            return null;
        }
    }

    /**
     * Write string.
     *
     * @param buf the buf
     * @param str the str
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void writeString(ObjectOutput buf, String str) throws IOException {

        if (null == str) {
            buf.writeInt(0);
        } else {
            byte[] bytes = str.getBytes();
            buf.writeInt(bytes.length);
            buf.write(bytes);
        }
    }
}
