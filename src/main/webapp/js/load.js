
    $(document).ready(function(){
		
		$('.dr-icon').click(function(){ 
                    if($(this).hasClass( "dr-icon-menu" ||"dr-label")){
                        
                        $("#home").removeClass('vissible');
                       
                       return null; 
                    }else{
			$("#home").addClass('vissible');
                        }
                });
               
	});

