<#import "macros/testcases.ftl" as testcasesMacro>

<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8"/>
    <title>Sandboy Report</title>
    <link rel="stylesheet" href="css/pico.min.css">
    <link rel="stylesheet" href="css/override.css">
    <link rel="stylesheet" href="css/chartist.min.css">
    <script src="js/chartist.min.js"></script>
</head>
<body>
<main class="container">
    <div class="grid">
        <div id="testsuiteArea">
            <article style="height: 90%;">
                <header>${testSuites?size} Test Suite(s) with ${numberOfTestcases} Test Case(s)</header>
                <ol>
                    <#list testSuites as testSuite>
                        <li><a href="#test-suite-${testSuite?counter}">${testSuite.name}</a></li>
                    </#list>
                </ol>
            </article>
        </div>
        <div id="chartArea">
            <article style="height: 90%;">
                <header>
                    <div style="text-align: center">
                        <span class="passed">Passed:</span> ${numberOfPassedTestcases} |
                        <span class="failed">Failed:</span> ${numberOfFailedTestcases} |
                        <span class="skipped">Skipped:</span> ${numberOfSkippedTestcases}
                    </div>
                </header>
                <div class="ct-chart ct-chart-donut ct-perfect-fifth"></div>
            </article>
        </div>
    </div>
    <#list testSuites as testSuite>
        <article>
            <header>
                <h4 id="test-suite-${testSuite?counter}">${testSuite.name}</h4>
                <i>
                    <span class="passed">Passed:</span> ${testSuite.numberOfPassedTestcases} |
                    <span class="failed">Failed:</span> ${testSuite.numberOfFailedTestcases} |
                    <span class="skipped">Skipped:</span> ${testSuite.numberOfSkippedTestcases} |
                    ${testSuite.time?c} seconds
                </i>
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
            <footer><a href="#top">Top</a></footer>
        </article>
    </#list>
</main>
<footer>
    <a href="https://github.com/bischoffdev/sandboy">Sandboy Report ${version}</a>
</footer>

<script type="text/javascript">
    const data = {
        labels: [' ', ' ', ' '],
        series: [
            {value: ${numberOfPassedTestcases}, className: 'passed'},
            {value: ${numberOfFailedTestcases}, className: 'failed'},
            {value: ${numberOfSkippedTestcases}, className: 'skipped'}
        ]
    };
    const config = {
        donut: true,
        donutWidth: 80
    };
    new Chartist.Pie('.ct-chart', data, config);
</script>

</body>
</html>