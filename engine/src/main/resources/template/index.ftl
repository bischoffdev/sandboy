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
                <i>Passed: ${testSuite.passCount} | Failed: ${testSuite.errorCount} | Skipped: ${testSuite.skipped} |
                    Test Suite Time: ${testSuite.time?c} seconds</i>
            </header>

            <#if testSuite.getNumberOfFailedTestcases() gt 0 >
                <article class="failed">
                    <header><strong>Failed</strong> - ${testSuite.getNumberOfFailedTestcases()} Test Case(s)</header>
                    <#list testSuite.getFailedTestcases() as testcase>
                        <@testcasesMacro.details testcase />
                    </#list>
                </article>
            </#if>
            <#if testSuite.getNumberOfPassedTestcases() gt 0>
                <article class="passed">
                    <header><strong>Passed</strong> - ${testSuite.getNumberOfPassedTestcases()} Test Case(s)</header>
                    <#list testSuite.getPassedTestcases() as testcase>
                        <@testcasesMacro.details testcase />
                    </#list>
                </article>
            </#if>
            <#if testSuite.getNumberOfSkippedTestcases() gt 0>
                <article class="skipped">
                    <header><strong>Skipped</strong> - ${testSuite.getNumberOfSkippedTestcases()} Test Case(s)</header>
                    <#list testSuite.getSkippedTestcases() as testcase>
                        <@testcasesMacro.details testcase />
                    </#list>
                </article>
            </#if>
        </article>
    </#list>
</main>
<footer>
    <a href="https://github.com/bischoffdev/sandboy">Sandboy Report ${version}</a>
</footer>
</body>
</html>