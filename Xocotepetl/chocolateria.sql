Table Chocolateria {
  Bebidas varchars [primary key]
  Comida varchar  [primary key]
  Enchocolatados varchar [primary key]
  }
 
Table Bebidas {
  Bebida_Tipo varchar [primary key]
  Frappe varchar
  Te varchar 
  Chocolate_caliente varchar
  Venta varchar
  Precio int
  
  }
  ref: Chocolateria.Bebidas < Bebidas.Bebida_Tipo
  Table Comida {
  Comida_Tipo varchar [primary key]
  Dona varchar
  Galleta varchar
  Bellini varchar
  Muffin varchar
  venta varchar
  Precio int
  }
  ref: Chocolateria.Comida < Comida.Comida_Tipo
Table Enchocolatados {
  Enchocolatado_Tipo varchar [primary key]
  Pasitas varchar
  Arandanos varchar
  Pretzel varchar
  Almendra varchar
  Almendra_con_Cafe varchar
  Nuez varchar
  Nuez_Macadamia varchar
  Avellana varchar
  Cafe_Oaxaca varchar
  Cafe_Veracruz varchar
  Cocoa varchar
  Con_Leche varchar
  Semiamargo varchar
  Venta varchar
  Precio int
  }
  ref: Chocolateria.Enchocolatados < Enchocolatados.Enchocolatado_Tipo
