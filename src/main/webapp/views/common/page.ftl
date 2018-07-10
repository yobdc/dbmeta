<nav aria-label="Page navigation example">
    <#assign currentIndex=pageData.pageNumber>
    <#assign range=5 >
    <#assign startPosition=pageData.pageNumber-range/2 >
    <#assign endPosition=pageData.pageNumber+range/2 >
    <#if startPosition gt 0>
        <#assign startIndex=startPosition>
    <#else>
        <#assign startIndex=1>
    </#if>
    <#if endPosition lte pageData.totalPage>
        <#assign endIndex=endPosition>
    <#else>
        <#assign endIndex=pageData.totalPage>
    </#if>
    <ul class="pagination">
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Start">
                <span aria-hidden="true">首页</span>
                <span class="sr-only">Start</span>
            </a>
        </li>
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">上一页</span>
                <span class="sr-only">Previous</span>
            </a>
        </li>
        <#list startIndex..endIndex as pageIndex>
            <li class="page-item"><a class="page-link" href="#">${pageIndex}</a></li>
        </#list>
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Next">
                <span aria-hidden="true">下一页</span>
                <span class="sr-only">Next</span>
            </a>
        </li>
        <li class="page-item">
            <a class="page-link" href="#" aria-label="End">
                <span aria-hidden="true">尾页</span>
                <span class="sr-only">End</span>
            </a>
        </li>
    </ul>
</nav>