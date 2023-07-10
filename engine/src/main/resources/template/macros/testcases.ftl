<#macro details testcase>
    <details>
        <summary>${testcase.name}</summary>
        <figure>
            <table>
                <tr>
                    <td>Time:</td>
                    <td>${testcase.time?c} seconds</td>
                </tr>
                <#if testcase.outputText?has_content>
                    <tr>
                        <td>Text:</td>
                        <td>
                            <pre><code>${testcase.getOutputText()!""}</code></pre>
                        </td>
                    </tr>
                </#if>
                <#if testcase.errorText?has_content>
                    <tr>
                        <td>Error:</td>
                        <td>
                            <pre><code>${testcase.getErrorText()!""}</code></pre>
                        </td>
                    </tr>
                </#if>
                <#if testcase.skipped?has_content>
                    <tr>
                        <td>Skipped:</td>
                        <td>
                            <pre><code>${testcase.skipped!""}</code></pre>
                        </td>
                    </tr>
                </#if>
            </table>
        </figure>
    </details>
</#macro>
