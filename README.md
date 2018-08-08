# Evaluación Navent Backend
Solución de la evaluación

### 2- Suponiendo que la tabla Pedidos tiene muchos registros y columnas (algunas de ellas nullable, algunas BLOB / "binary-large-object"), que consideraciones se deberían tener en cuenta para realizar desde un sitio web consultas a la base de datos de manera eficiente?

Al trabajar con base de datos masivas hay que tener en cuenta la performance de las consultas.

1. Se debería tratar de separar la tabla Pedidos, las columnas de tipo BLOB deberían estar en otra tabla, esto mejora el manejo de la tabla Pedidos.

2. Debe evitarse consultas del tipo "select *" y solo acceder a las columnas que sean necesarias para una determinada operación.

3. Emplear un índice para acceder de forma más rápida a los registros de la base de datos. 
