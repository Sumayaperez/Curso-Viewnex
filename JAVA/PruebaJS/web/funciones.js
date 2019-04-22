/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var x2;
x2 = $(document);
x2.ready(recorrer);

function recorrer(){
    $("li").each(function(){
        //console.log('el elemento con indice '+indice+' contiene ' +$(elemento).text());   
        $(this).html("cada elemento nuevo");
    });
    
}




/*
function recorrer(){
    $("li").each(function(indice,elemento){
        console.log('el elemento con indice '+indice+' contiene ' +$(elemento).text());   
        $(elemento).innerHTML += "-" +$(elemento);
    });
    
}
*/


