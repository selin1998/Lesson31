<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <style type="text/css">
        table {
            width: 100%;
        }

        th{
            background-color: #4CAF50;
            color: white;
        }
        td{
            text-align: center;
        }
        tr:nth-child(even) {background-color: #f2f2f2;}
    </style>
    <title>Document</title>
</head>
<body>
    <table border="1">
        <tbody>
        <tr>
            <th>a</th>
            <th>operation</th>
            <th>b</th>
            <th></th>
            <th>result</th>
        </tr>
        <#list operations as operation>
            <tr>
                <td>${operation.a}</td>
                <td>${operation.operation}</td>
                <td>${operation.b}</td>
                <td>=</td>
                <td>${operation.result}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</body>
</html>
