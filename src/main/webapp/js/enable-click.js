
$(document).ready(function(){
   
//mail validation
function isValidEmailAddress(emailAddress) {
    var pattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/i;
    if( pattern.test(emailAddress)){
        return true;
    };return false;
};
/*name validation
function isValidName(name){
    var RegExpression = /^[a-zA-Z\s]*$/
    if (RegExpression.test(name)){
        return true;
    };return false;
}
/**/
(function() {
    $('form > input[type=email]').on("click",function(){
       var selected='#'+ $(this).attr('id');
       //console.log(selected);
    
    //$('form > input')
    $(selected).keyup(function() {
           if(selected=="#mail-cv"){
               var form='.form';
               
           }   else {var form='.form1';}  
        var empty = false;
        $(selected).each(function() {
            if ($(this).val() == '' ||!( isValidEmailAddress($(form).val()))) {
                empty = true;
            }//console.log(empty);
        });
        if(selected=="#mail-cv"){//console.log("cv");
        if (empty) {
            $('#cv-pdf').attr('class','disable-click'); 
            $('#cv1-pdf').attr('class','disable-click');
            
        } else {
            $('#cv-pdf').attr('class','enable-click'); 
            $('#cv1-pdf').attr('class','enable-click');
            
        }
    }
    else if(selected=="#mail"){//console.log('ok');
            if (!empty) {
           // $('#input-submit').attr('disable','disable'); 
           //console.log("ok2");
            
       // } else {
            $('#input-submit').removeClass('disable-click'); 
            console.log("ok3");
            
        }else $('#input-submit').addClass('disable-click');
       // console.log($(this).css('pointer-events'));
        
    }
    });
    
    });
    
})()

});
