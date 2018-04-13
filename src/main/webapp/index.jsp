<html>
<head>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/check.js"></script>
    <script type="text/javascript"  src="jquery-easyui-1.3.5/jquery.min.js"></script>
</head>
<body>
    <form>
       <div class="panel admin-panel">
           <div class="panel-head"><strong>RSA</strong></div>
           <table class="table table-hover" border="1">
               <tr>
                   <td>p</td>
                   <td><textarea id="rsa_p" onchange="checkRSAp()"></textarea></td>
                   <td><a class="button border-yellow button-little" onclick="generateRSAp()">generate p</a></td>
               </tr>

               <tr>
                    <td>q</td>
                    <td><textarea id="rsa_q" onchange="checkRSAq()"></textarea></td>
                   <td><a class="button border-yellow button-little" onclick="generateRSAq()">generate q</a></td>
               </tr>

               <tr>
                   <td>e</td>
                   <td><textarea id="rsa_e" onchange="checkRSAe()"></textarea></td>
                   <td><a class="button border-blue button-little" onclick="generateRSAe()">generate e</a></td>
               </tr>

               <tr>
                    <td>plaintext</td>
                    <td><textarea id="rsa_plaintext"></textarea></td>
                   <td><a class="button border-blue button-little" onclick="encode()">encode</a></td>
               </tr>

               <tr>
                    <td>ciphertext</td>
                    <td><textarea id="rsa_ciphertext"></textarea></td>
                   <td><a class="button border-yellow button-little" onclick="decode()">decode</a></td>
               </tr>

           </table>
       </div>
    </form>
</body>
</html>
