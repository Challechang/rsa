<html>
<head>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/check.js"></script>
</head>
<body>
    <form>
       <div class="panel admin-panel">
           <div class="panel-head"><strong>RSA</strong></div>
           <table class="table table-hover" border="1">
               <tr>
                   <td>p</td>
                   <td><textarea id="rsa_p" onblur="checkRSAp()"></textarea></td>
               </tr>
                    <td>q</td>
                    <td><textarea id="rsa_q" onblur="checkRSAq()"></textarea></td>
               <tr>
                    <td>plaintext</td>
                    <td><textarea id="rsa_plaintext"></textarea></td>
               </tr>

               <tr>
                    <td>ciphertext</td>
                    <td><textarea id="rsa_ciphertext"></textarea></td>
               </tr>
           </table>
       </div>
    </form>
</body>
</html>
