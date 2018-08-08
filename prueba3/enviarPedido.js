function validarForm(){
	var nombre, monto, descuento;
	
	nombre = document.getElementById("nombre").value;
	if (nombre == null || nombre.length == 0){
		alert("Debe ingresar un nombre");
		document.formulario.nombre.focus();
		return false;
	}
	if (nombre.length > 100){
		alert("El nombre es muy largo");
		document.formulario.nombre.focus();
		return false;
	}

	monto = document.getElementById("monto").value;
	if (monto == null || monto.length == 0){
		alert("Debe ingresar el monto");
		document.formulario.monto.focus();
		return false;
	}
	if (!Number.isInteger(Number(monto)) || Number(monto) < 0){ 
		alert("Ingrese un monto entero válido");
		document.formulario.monto.value = "";
		document.formulario.monto.focus();
		return false;
	}

	descuento = document.getElementById("descuento").value;
	if (!Number.isInteger(Number(descuento)) || Number(descuento) < 0){
		alert("Ingrese un descuento entero válido");
		document.formulario.descuento.value = "";
		document.formulario.descuento.focus();
		return false;
	}
	return true;
}

$(document).ready(function () {
    $("#formulario").bind("submit",function(){
       	if (!validarForm()){
       		return false;
       	}
       	$.ajax({
		type: $(this).attr("method"),
		//url: "procesarPedido.php",
		url: "pedido/guardar", 
       		data: $("#formulario").serialize(),
       		success: function(data){
       			$(".respuesta").html(data);
       		},
       		error: function (data){
       			$(".respuesta").html(data);
       			alert("Problemas al enviar");
       		}
       	});

        return false;
    });
});
