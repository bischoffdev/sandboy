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
    <#list testSuites as testSuite>
        <article>
            <header>
                <h4>Test Suite: ${testSuite.name}</h4>
                Passed: ${testSuite.passCount} / Failed: ${testSuite.errorCount} / Skipped: ${testSuite.skipped} /
                Test Suite Time: ${testSuite.time?c} seconds
            </header>

            <article>
                <header>Failed</header>
                <#list testSuite.testcases as testcase>
                    <details>
                        <summary>${testcase.name}</summary>
                        <figure>
                            <table role="grid">
                                <tr>
                                    <td>Time:</td>
                                    <td>${testcase.time?c} seconds</td>
                                </tr>
                                <tr>
                                    <td>Text:</td>
                                    <td>
                                        <pre><code>${testcase.getOutputText()!""}</code></pre>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Error:</td>
                                    <td>
                                        <pre><code>${testcase.getErrorText()!""}</code></pre>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Skipped:</td>
                                    <td>
                                        <pre><code>${testcase.skipped!""}</code></pre>
                                    </td>
                                </tr>
                            </table>
                        </figure>
                    </details>
                </#list>
            </article>
            <article>
                <header>Skipped</header>
                blabla
            </article>
            <article>
                <header>Failed</header>
                blabla
            </article>
        </article>
    </#list>
</main>
<footer>
    <a href="https://github.com/bischoffdev/sandboy">Sandboy Report ${version}</a>
</footer>
</body>
</html>