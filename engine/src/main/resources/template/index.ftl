<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Sandboy Report</title>
    <link rel="stylesheet" href="css/pico.classless.min.css">
    <link rel="stylesheet" href="css/override.css">
</head>
<body>
<header>Sandboy Report ${version}</header>
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
                    <tr>
                        <td>Text:</td>
                        <td>${testcase.text!""}</td>
                    </tr>
                    <tr>
                        <td>Failure:</td>
                        <td>${testcase.failure!""}</td>
                    </tr>
                    <tr>
                        <td>Rerun Failure:</td>
                        <td>${testcase.rerunFailure!""}</td>
                    </tr>
                    <tr>
                        <td>Flaky Failure:</td>
                        <td>${testcase.flakyFailure!""}</td>
                    </tr>
                    <tr>
                        <td>Error:</td>
                        <td>${testcase.error!""}</td>
                    </tr>
                    <tr>
                        <td>Rerun Error:</td>
                        <td>${testcase.rerunError!""}</td>
                    </tr>
                    <tr>
                        <td>Flaky Error:</td>
                        <td>${testcase.flakyError!""}</td>
                    </tr>
                    <tr>
                        <td>Skipped:</td>
                        <td>${testcase.skipped!""}</td>
                    </tr>
                    <tr>
                        <td>System error:</td>
                        <td>${testcase.systemError!""}</td>
                    </tr>
                    <tr>
                        <td>System out:</td>
                        <td>${testcase.systemOut!""}</td>
                    </tr>
                </table>
            </figure>
        </#list>
    </#list>
</main>
<footer>Footer</footer>
</body>
</html>