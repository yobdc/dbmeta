<nav aria-label="Page navigation example">
    <#assign currentIndex=pageData.pageNumber>
    <#assign range=5 >
    <#assign totalPage=pageData.totalPage >
    <#if totalPage = 0>
        <#assign totalPage=1 >
    </#if>
    <#assign startPosition=(pageData.pageNumber-range/2)?ceiling >
    <#assign endPosition=pageData.pageNumber+range/2 >
    <#if startPosition gt 0>
        <#assign startIndex=startPosition>
    <#else>
        <#assign startIndex=1>
    </#if>
    <#if endPosition lte totalPage>
        <#assign endIndex=endPosition>
    <#else>
        <#assign endIndex=totalPage>
    </#if>
    <ul class="pagination">
        <li class="page-item">
            <a class="page-link" href="${request.requestURI}?page=1&size=${pageData.pageSize}" aria-label="Start">
                <span aria-hidden="true">首页</span>
                <span class="sr-only">Start</span>
            </a>
        </li>
        <li class="page-item">
            <a class="page-link"
               <#if currentIndex gt 1>
               href="${request.requestURI}?page=${currentIndex-1}&size=${pageData.pageSize}"
               <#else>
               href="#"
               </#if>
               aria-label="Previous">
                <span aria-hidden="true">上一页</span>
                <span class="sr-only">Previous</span>
            </a>
        </li>
        <#list startIndex..endIndex as pageIndex>
            <li class="page-item"><a class="page-link" href="${request.requestURI}?page=${pageIndex}&size=${pageData.pageSize}">${pageIndex}</a></li>
        </#list>
        <li class="page-item">
            <a class="page-link"
               <#if currentIndex lt pageData.totalPage>
               href="${request.requestURI}?page=${currentIndex-1}&size=${pageData.pageSize}"
               <#else>
               href="#"
               </#if>
                aria-label="Next">
                <span aria-hidden="true">下一页</span>
                <span class="sr-only">Next</span>
            </a>
        </li>
        <li class="page-item">
            <a class="page-link" href="${request.requestURI}?page=${pageData.totalPage}&size=${pageData.pageSize}" aria-label="End">
                <span aria-hidden="true">尾页</span>
                <span class="sr-only">End</span>
            </a>
        </li>
    </ul>
</nav>