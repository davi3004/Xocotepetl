package xocotepetl;

public class Productos extends DatosInventario {
    
    private int ID_Producto;
    private String Nombre;
    private String descripcion;
    private float precio;


    public Productos( int ID_Producto, String Nombre, String descripcion, float precio) {
        super( ID_Producto,Nombre, precio);
       
        this.ID_Producto=ID_Producto;
        this.Nombre = Nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        
    }
    
    @Override
    public int getIDproducto() {
        return ID_Producto;
    }
    
    @Override
    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }
    
    
    @Override
    public String getNombre() {
        return Nombre;
    }

    @Override
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public float getPrecio() {
        return precio;
    }
    @Override
    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
