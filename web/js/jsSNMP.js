function addOID()
{
    var numero  = Number($('#numeroCamposOID').val()) + 1;
    var html    =   "                                               "+
                    "     <div class='3u margin-bottom' id='OID_"+numero+"'>      "+
                    "        <input                                 "+
                    "            type='text'                        "+
                    "            id='OID_"+numero+"'                "+
                    "            name='OID_"+numero+"'              "+
                    "            placeholder='OID'                  "+
                    "            required                           "+
                    "        ><br/>                                 "+
                    "        <img                                   "+
                    "            src='img/apagar.png'               "+
                    "            class='iconeApagar center'         "+
                    "            onclick=\"apagar('"+numero+"')\"    "+
                    "        >                                      "+
                    "    </div>                                     ";

    $('#camposOID').append(html);
    $('#numeroCamposOID').val(numero);
}

function apagar(numero)
{
    $('#OID_'+numero).html('');
}