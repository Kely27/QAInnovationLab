# language: es
Característica: Agregar producto al carrito
Como usuario de la app movil me encuentro dentro
de la plicación SauceLabs quiero agregar un producto
y que se muestre en el carrito de compras

@Navegacion @Smoke
Escenario: Validaciòn correcta del agregado del producto
Dado estoy en la aplicación "miApp"
Y valido que carguen correctamente los productos en la galeria
Cuando Selecciono el primer producto "Sauce Labs Backpack"
Y Selecciono la cantidad del producto
Y agrego el producto al carrito
Y retorno a la lista de productos
Entonces valido el carrito de compra actualice correctamente