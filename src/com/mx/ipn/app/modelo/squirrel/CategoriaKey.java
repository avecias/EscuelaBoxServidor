/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Thu Apr 07 13:42:43 CDT 2016
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package com.mx.ipn.app.modelo.squirrel;

public class CategoriaKey implements java.io.Serializable, Cloneable {
    /* idCategoria */
    protected int idcategoria;

    /* idCategoria */
    public int getIdcategoria() {
        return idcategoria;
    }

    /* idCategoria */
    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        hashCode += new Integer(idcategoria).hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof CategoriaKey))
            return false;

        CategoriaKey key = (CategoriaKey) obj;

        if (this.idcategoria != key.idcategoria)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        CategoriaKey key = new CategoriaKey();
        key.idcategoria = this.idcategoria;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idcategoria").append(" = ").append(idcategoria).append("]");
        return sb.toString();
    }
}