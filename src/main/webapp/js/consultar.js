$(document).ready(function(){
$('.btnconsulus').on('click',function(){
	consultarusuarios();
});
$('.btnconsulcli').on('click',function(){
	consultarclientes();
});

	function consultarusuarios(){
		$.ajax({
		  url: "ServletGestionUsuarios",
		  type:"POST",
		  dataType:"json",
		  success: function( result ) {
			console.log(result);
			let tabla = document.querySelector('#tab');
			console.log(tabla);
			tabla.innerHTML="";
			tabla.innerHTML=`<tr><th>Documento del usuario</th>
							<th>Nombre del usuario</th>
							<th>Correo electronico del usuario</th>
							<th>Usuario</th>
							<th>Password</th>
							</tr>`;
			for(let i of result){
				tabla.innerHTML+=`<tr><td>${i.docus}</td>
									<td>${i.nomus}</td>
									<td>${i.emailus}</td>
									<td>${i.us}</td>
									<td>${i.passus}</td>
									</tr>`;
			}
			
		}
});
}
	function consultarclientes(){
		$.ajax({
		  url: "ServletGestionClientes",
		  type:"POST",
		  dataType:"json",
		  success: function( result ) {
			console.log(result);
			let tabla=document.querySelector('#tab');
			console.log(tabla);
			tabla.innerHTML="";
			tabla.innerHTML=`<tr><th>Cedula del cliente</th>
							<th>Nombre del cliente</th>
							<th>Direccion del cliente</th>
							<th>Telefono del cliente</th>
							<th>Correo del cliente</th>
							</tr>`;
			for(let i of result){
				tabla.innerHTML+=`<tr><td>${i.doccli}</td>
								<td>${i.nomcli}</td>
								<td>${i.dircli}</td>
								<td>${i.telcli}</td>
								<td>${i.emailcli}</td>
								</tr>`;
			}
		
	}
});
}
});