<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Sandboy Report</title>
    <link rel="stylesheet" href="css/pico.classless.min.css">
    <link rel="stylesheet" href="css/override.css">
</head>
<body>
<header>Sandboy Report</header>
<main class="container">

    <#list testSuites as testSuite>
        <h1>${testSuite.name}</h1>
        <h2>Summary</h2>
        <ul>
            <li>Passed: <strong>${testSuite.passCount}</strong></li>
            <li>Skipped: <strong>${testSuite.skipped}</strong></li>
            <li>Failed: <strong>${testSuite.errorCount}</strong></li>
            <li>Time: <strong>${testSuite.time?c}</strong></li>
        </ul>

        <h2>Test Cases</h2>
        <#list testSuite.testcases as testcase>
            <h3 data-tooltip="${testcase.classname}">${testcase.name}</h3>
            <figure>
                <table>
                    <tr>
                        <td>Time:</td>
                        <td>${testcase.time?c}</td>
                    </tr>
                </table>
            </figure>
        </#list>
    </#list>
</main>
<footer>Footer</footer>
</body>
</html>