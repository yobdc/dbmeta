<nav aria-label="Page navigation example">
    <#assign startIndex=1 endIndex=pageData.totalPage currentIndex=pageData.pageNumber>
    <ul class="pagination">
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Start">
                <span aria-hidden="true">开始</span>
                <span class="sr-only">首页</span>
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
                <span aria-hidden="true">&raquo;</span>
                <span class="sr-only">下一页</span>
            </a>
        </li>
        <li class="page-item">
            <a class="page-link" href="#" aria-label="End">
                <span aria-hidden="true">&raquo;</span>
                <span class="sr-only">尾页</span>
            </a>
        </li>
    </ul>
</nav>