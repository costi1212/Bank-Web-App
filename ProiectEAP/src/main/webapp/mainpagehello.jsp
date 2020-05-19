<%@ page import="models.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Steph
  Date: 5/19/2020
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>




    body {

        flex-direction: column;
        justify-content: center;
        align-items: center;
        font-family: "fira-sans-2", Verdana, sans-serif;
    }


    .overlay {
        height: 100%;
        width: 0;
        position: fixed;
        z-index: 1;
        top: 0;
        left: 0;
        background-color: rgb(0,0,0);
        background-color: rgba(0,0,0, 0.9);
        overflow-x: hidden;
        transition: 0.5s;
    }

    .overlay-content {
        position: relative;
        top: 25%;
        width: 100%;
        text-align: center;
        margin-top: 30px;
    }

    .overlay a {
        padding: 8px;
        text-decoration: none;
        font-size: 36px;
        color: #818181;
        display: block;
        transition: 0.3s;
    }

    .overlay a:hover, .overlay a:focus {
        color:#39cccc;
    }

    .overlay .closebtn {
        position: absolute;
        top: 20px;
        right: 45px;
        font-size: 60px;
    }

    @media screen and (max-height: 450px) {
        .overlay a {font-size: 20px}
        .overlay .closebtn {
            font-size: 40px;
            top: 15px;
            right: 35px;
        }
    }
    p1{
        margin-left: 16px;
        font-size: 30px;

    }

    #q-graph {


        display: block; /* fixes layout wonkiness in FF1.5 */
        position: relative;
        width: 600px;
        height: 300px;
        margin: 1.1em 0 0;
        padding: 0;
        background: transparent;
        font-size: 11px;
        margin-left: 35%;

    }

    #q-graph caption {
        caption-side: top;
        width: 600px;
        text-transform: uppercase;
        letter-spacing: .5px;
        top: -40px;
        position: relative;
        z-index: 10;
        font-weight: bold;
    }

    #q-graph tr, #q-graph th, #q-graph td {
        position: absolute;
        bottom: 0;
        width: 150px;
        z-index: 2;
        margin: 0;
        padding: 0;
        text-align: center;
    }

    #q-graph td {
        transition: all .3s ease;
    }

    #q-graph thead tr {
        left: 100%;
        top: 50%;
        bottom: auto;
        margin: -2.5em 0 0 5em;}
    #q-graph thead th {
        width: 7.5em;
        height: auto;
        padding: 0.5em 1em;
    }
    #q-graph thead th.sent {
        top: 0;
        left: 0;
        line-height: 2;
    }
    #q-graph thead th.paid {
        top: 2.75em;
        line-height: 2;
        left: 0;
    }

    #q-graph tbody tr {
        height: 296px;
        padding-top: 2px;
        border-right: 1px dotted #C4C4C4;
        color: #AAA;
    }
    #q-graph #q1 {
        left: 0;
    }
    #q-graph #q2 {left: 150px;}
    #q-graph #q3 {left: 300px;}
    #q-graph #q4 {left: 450px; border-right: none;}
    #q-graph tbody th {bottom: -1.75em; vertical-align: top;
        font-weight: normal; color: #333;}
    #q-graph .bar {
        width: 60px;
        border: 1px solid;
        border-bottom: none;
        color: #000;
    }
    #q-graph .bar p {
        margin: 5px 0 0;
        padding: 0;
        opacity: .4;
    }
    #q-graph .sent {
        left: 13px;
        background-color:#39cccc;
        border-color: transparent;
    }
    #q-graph .paid {
        left: 77px;
        background-color: #39cccc;
        border-color: transparent;
    }


    #ticks {
        position: relative;
        top: -300px;
        left: 2px;
        width: 596px;
        height: 300px;
        z-index: 1;
        margin-bottom: -300px;
        font-size: 10px;
        font-family: "fira-sans-2", Verdana, sans-serif;
    }

    #ticks .tick {
        position: relative;
        border-bottom: 1px dotted #C4C4C4;
        width: 600px;
    }

    #ticks .tick p {
        position: absolute;
        left: -5em;
        top: -0.8em;
        margin: 0 0 0 0.5em;
    }
    .container {
        text-align: center;
        padding: 5px;
    }
    body {font-family: Arial, Helvetica, sans-serif;}

    /* The Modal (background) */
    .modal {
        display: none; /* Hidden by default */
        position: fixed; /* Stay in place */
        z-index: 1; /* Sit on top */
        padding-top: 100px; /* Location of the box */
        left: 0;
        top: 0;
        width: 100%; /* Full width */
        height: 100%; /* Full height */
        overflow: auto; /* Enable scroll if needed */
        background-color: rgb(0,0,0); /* Fallback color */
        background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    }

    /* Modal Content */
    .modal-content {
        background-color: #fefefe;
        margin: auto;
        padding: 20px;
        border: 1px solid #888;
        width: 80%;
    }

    /* The Close Button */
    .close {
        color: #aaaaaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }

    .close:hover,
    .close:focus {
        color: #000;
        text-decoration: none;
        cursor: pointer;
    }
    input[type=text] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        box-sizing: border-box;
        border: none;
        border-bottom: 2px solid #39cccc;
    }
    input[type=button] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        box-sizing: border-box;
        border-top-left-radius: 15px;
        border-bottom-right-radius: 15px;
        background:#39cccc;

    }
    .butonpop-up {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        box-sizing: border-box;
        border-top-left-radius: 15px;
        border-top-right-radius: 15px;
        border-bottom-right-radius: 15px;
        border-bottom-left-radius: 15px;
        background: #39cccc;
    }
    input[type=submit] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        box-sizing: border-box;
        border-top-left-radius: 15px;
        border-top-right-radius: 15px;
        border-bottom-right-radius: 15px;
        border-bottom-left-radius: 15px;
        background: #39cccc;
    }
</style>

<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<head>
</head>
<body>


<p style="font-size: 30px;text-align: center;position: center;padding-top: 10px;" align="center">
<div id="myNav" class="overlay">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <div class="overlay-content">
        <a href="#">Pagina Hello</a>
        <a href="#">Prieteni</a>
    </div>
</div>
<span style="font-size:30px;cursor:pointer;alignment:center;text-align: center;" onclick="openNav()">&#9776; Open Menu </span>
<p style="font-size: 30px;text-align: center;position: center;padding-top: 10px;" align="center">
    <%
        if (request.getAttribute("name") != null) {
            out.print("Hello, " + request.getAttribute("name"));
            out.print("<br>");
            out.print("<br>");

        }
    %>
</p>
</p>

<p1>Your Cards :</p1>


<div class="wrapper">
    <div class="w3-container" style="width: 100%;text-align: center;">

        <p><%
            if (request.getAttribute("accounts")!=null){
                String it="0";
                for (Account account:(List<Account>)request.getAttribute("accounts")){
                    it=Integer.toString(Integer.parseInt(it)+1);
                    String nr_card=" <div class=\"w3-card-4\" style=\"width:25%;display:inline-block;margin:2%;\">\n" +
                            "            <header class=\"\">\n" +
                            "                <h3>"+account.getNrCard()+"</h3>\n" +
                            "            </header>\n" +
                            "            <div class=\"w3-container\">\n" +
                            "                <p>"+account.getValuta()+"</p><br>\n" +
                            "                <hr>\n" +
                            "                <p>"+account.getAmount()+"</p><br>\n" +

                            "            </div>\n" +
                            "            <button id='myBtn"+it+"' class=\"butonpop-up\" >Depunere/Retragere</button>\n" +

                            "        </div>" +
                            "<div id=\"myModal"+it+"\" class=\"modal\">\n" +
                            "\n" +
                            "            <!-- Modal content -->\n" +
                            "            <div class=\"modal-content\">\n" +
                            "                <span class=\"close\">&times;</span>\n" +
                            "                <form method='post' action='/mainpagehello'>\n" +
                            "                    <label for=\"suma\">Introduceti Suma</label>\n" +
                            "                    <input type=\"text\" id=\"suma\" name=\"suma\">\n" +
                            "                    <input type='hidden' name='nrCardcont' value='"+account.getNrCard()+"'>\n" +
                            "                    <input type='submit' name='Confirmati suma' value='Confirmati suma'/>\n" +
                            "                    <input type='hidden' name='userName' value='"+request.getAttribute("name")+"'>\n"+
                            "                </form>\n" +
                            "            </div>\n" +
                            "\n" +
                            "        </div>";
                    out.print(nr_card);
                }
            }



        %></p>
    </div>

</div>


<div class="container">
    <table id="q-graph" align="centre">
        <caption>Your Total Revenue Per Account(Ron)</caption>



        <p><%

            if (request.getAttribute("accounts")!=null){
                int value=0;
                for (Account account:(List<Account>)request.getAttribute("accounts")){
                    value++;
                    String nr_card=" <tr class=\"qtr\" id=\"q"+value+"\">\n" +
                            "            <td class=\"sent bar\" style=\"height:"+0.02 *account.ConversieLaRon()+"%;\"><p>"+account.ConversieLaRon()+"</p></td>\n" +
                            "        </tr> ";
                    out.print(nr_card);
                }
            }








        %></p>

        </tbody>
    </table>


</div>


</body>
</html>

<script>
    function openNav() {
        document.getElementById("myNav").style.width = "30%";
    }

    function closeNav() {
        document.getElementById("myNav").style.width = "0%";
    }
    // Get the modal
    //var modal = document.getElementsByClassName('modal');

    // Get the button that opens the modal
    var btn = document.getElementsByClassName("butonpop-up");

    // All page modals
    var modals = document.getElementsByClassName('modal');

    // Get the <span> element that closes the modal
    var spans = document.getElementsByClassName("close");

    // When the user clicks the button, open the modal
    for (let i = 0; i < btn.length; i++) {
        btn[i].onclick = function() {
            modals[i].style.display = "block";
        }
    }

    // When the user clicks on <span> (x), close the modal
    for (let i = 0; i < spans.length; i++) {
        spans[i].onclick = function() {
            modals[i].style.display = "none";
        }
    }


    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>
