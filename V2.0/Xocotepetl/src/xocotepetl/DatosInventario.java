package xocotepetl;

public class DatosInventario {
    
    private int ID_Producto;
    private String Nombre;

    private float precio;

    public DatosInventario(int ID_Producto, String Nombre, float precio) {

        this.ID_Producto=ID_Producto;
        
        this.Nombre = Nombre;

        this.precio = precio;
    }
   

    public int getIDproducto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }


    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
}

