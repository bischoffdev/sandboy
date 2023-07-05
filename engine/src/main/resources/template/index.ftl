<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8"/>
    <title>Sandboy Report</title>
    <link rel="stylesheet" href="css/pico.min.css">
    <link rel="stylesheet" href="css/override.css">
</head>
<body>
<main class="container-fluid">
    <nav>
        <h1>Sandboy Report</h1>
    </nav>
    <#list testSuites as testSuite>
        <article>
            <header>
                <h4>${testSuite.name}</h4>
                <article style="width: 50%; padding: 0;">
                    <table role="grid" style="table-layout: fixed">
                        <tr>
                            <td>Passed</td>
                            <td>${testSuite.passCount}</td>
                        </tr>
                        <tr>
                            <td>Failed</td>
                            <td>${testSuite.errorCount}</td>
                        </tr>
                        <tr>
                            <td>Skipped</td>
                            <td>${testSuite.skipped}</td>
                        </tr>
                        <tr>
                            <td>Test Suite Time</td>
                            <td>${testSuite.time?c} seconds</td>
                        </tr>
                    </table>
                </article>
            </header>

            <#list testSuite.testcases as testcase>
                <details>
                    <summary>${testcase.name}</summary>
                    <figure>
                        <table role="grid">
                            <tr>
                                <td>Time:</td>
                                <td>${testcase.time?c}</td>
                            </tr>
                            <tr>
                                <td>Text:</td>
                                <td>
                                    <pre>${testcase.text!""}</pre>
                                </td>
                            </tr>
                            <tr>
                                <td>Failure:</td>
                                <td>
                                    <pre>${testcase.failure!""}</pre>
                                </td>
                            </tr>
                            <tr>
                                <td>Rerun Failure:</td>
                                <td>
                                    <pre>${testcase.rerunFailure!""}</pre>
                                </td>
                            </tr>
                            <tr>
                                <td>Flaky Failure:</td>
                                <td>
                                    <pre>${testcase.flakyFailure!""}</pre>
                                </td>
                            </tr>
                            <tr>
                                <td>Error:</td>
                                <td>
                                    <pre>${testcase.error!""}</pre>
                                </td>
                            </tr>
                            <tr>
                                <td>Rerun Error:</td>
                                <td>
                                    <pre>${testcase.rerunError!""}</pre>
                                </td>
                            </tr>
                            <tr>
                                <td>Flaky Error:</td>
                                <td>
                                    <pre>${testcase.flakyError!""}</pre>
                                </td>
                            </tr>
                            <tr>
                                <td>Skipped:</td>
                                <td>
                                    <pre>${testcase.skipped!""}</pre>
                                </td>
                            </tr>
                            <tr>
                                <td>System error:</td>
                                <td>
                                    <pre>${testcase.systemError!""}</pre>
                                </td>
                            </tr>
                            <tr>
                                <td>System out:</td>
                                <td>
                                    <pre>${testcase.systemOut!""}</pre>
                                </td>
                            </tr>
                        </table>
                    </figure>
                </details>
            </#list>
        </article>
    </#list>
</main>
<footer>
    <a href="https://github.com/bischoffdev/sandboy">Sandboy Report ${version}</a>
</footer>
</body>
</html>