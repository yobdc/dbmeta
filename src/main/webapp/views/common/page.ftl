<nav aria-label="Page navigation example">
    <#assign startIndex=1 endIndex=pageData.totalPage currentIndex=pageData.pageNumber>
    <ul class="pagination">
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
                <span class="sr-only">Previous</span>
            </a>
        </li>
        <#list startIndex..endIndex as pageIndex>
            <li class="page-item"><a class="page-link" href="#">${pageIndex}</a></li>
        </#list>
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
                <span class="sr-only">Next</span>
            </a>
        </li>
    </ul>
</nav>