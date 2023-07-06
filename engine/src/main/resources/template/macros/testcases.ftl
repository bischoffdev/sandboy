<#macro details testcase>
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
</#macro>
