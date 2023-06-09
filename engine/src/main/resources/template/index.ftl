<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Sandboy Report</title>
    <link rel="stylesheet" href="css/pico.classless.min.css">
</head>
<body>
<header>Sandboy Report</header>
<main class="container">
    <h1>Test Suites</h1>
    <#list testSuites as testSuite>
        <h2>${testSuite.name}</h2>

        <p>
            ${testSuite.tests} tests:<br>
            ${testSuite.passCount} passed / ${testSuite.errorCount} failed / ${testSuite.skipped} skipped
        </p>

        <ul>
            <#list testSuite.testcases as testcase>
                <li>
                    <strong>${testcase.name}</strong><br>
                    <i>(${testcase.classname})</i>
                </li>
            </#list>
        </ul>
    </#list>

    <table>
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Heading</th>
            <th scope="col">Heading</th>
            <th scope="col">Heading</th>
            <th scope="col">Heading</th>
            <th scope="col">Heading</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Cell</td>
            <td>Cell</td>
            <td>Cell</td>
            <td>Cell</td>
            <td>Cell</td>
        </tr>
        <tr>
            <th scope="row">1</th>
            <td>Cell</td>
            <td>Cell</td>
            <td>Cell</td>
            <td>Cell</td>
            <td>Cell</td>
        </tr>
        <tr>
            <th scope="row">1</th>
            <td>Cell</td>
            <td>Cell</td>
            <td>Cell</td>
            <td>Cell</td>
            <td>Cell</td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <th scope="col">#</th>
            <td scope="col">Total</td>
            <td scope="col">Total</td>
            <td scope="col">Total</td>
            <td scope="col">Total</td>
            <td scope="col">Total</td>
        </tr>
        </tfoot>
    </table>
</main>
<footer>Footer</footer>
</body>
</html>