<#import "macros/testcases.ftl" as testcasesMacro>

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
                <h4>${testSuite.name}</h4>
                Passed: ${testSuite.passCount} / Failed: ${testSuite.errorCount} / Skipped: ${testSuite.skipped} /
                Test Suite Time: ${testSuite.time?c} seconds
            </header>

            <article class="failed">
                <header>Failed</header>
                <#list testSuite.getFailedTestcases() as testcase>
                    <@testcasesMacro.details testcase />
                </#list>
            </article>
            <article class="passed">
                <header>Passed</header>
                <#list testSuite.getPassedTestcases() as testcase>
                    <@testcasesMacro.details testcase />
                </#list>
            </article>
            <article class="skipped">
                <header>Skipped</header>
                <#list testSuite.getSkippedTestcases() as testcase>
                    <@testcasesMacro.details testcase />
                </#list>
            </article>
        </article>
    </#list>
</main>
<footer>
    <a href="https://github.com/bischoffdev/sandboy">Sandboy Report ${version}</a>
</footer>
</body>
</html>