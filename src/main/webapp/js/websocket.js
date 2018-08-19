var websocket= new WebSocket("ws://localhost:8080/homepage/email");
              // console.log("got connected");

function dfr(){
               // var websocket= new WebSocket("ws://localhost:8080/homepage/email");
               // console.log("got connected");
                var host= document.getElementById('mail-cv').value;
                console.log(host);
                setTimeout(function(){websocket.send(host);},2000);
                //websocket.close();
                return false;
            }
    
 function dfe(){
                //var websocket= new WebSocket("ws://localhost:8080/homepage/email");
                //console.log("got connected");
                var host= document.getElementById('mail').value;
                var mess=document.getElementById('input-message').value;
                var string=host+"~"+mess;
                console.log(string);
                setTimeout(function(){websocket.send(string);},2000);
               
                return false;
 }              
                
        
