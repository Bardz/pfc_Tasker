    function handleLoginRequest(xhr, status, args) {  
        if(args.validationFailed || !args.loggedIn) {  
            PF('dlg').jq.effect("shake", { times:5 }, 100);  
            
        }   
        else {  
            PF('dlg').hide();  
            $('#loginLink').fadeOut();
            window.location ="/pfcTasker/areausuario.xhtml";
            teste(document.getElementById(button), document.getElementById(teste));           
        }    
    }
    