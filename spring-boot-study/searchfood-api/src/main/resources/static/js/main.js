// console.log('hello~');

// 검색 버튼을 눌렀을 때 이벤트
$('#searchButton').click(function() {
    console.log('search btn click');

    const query = $('#searchBox').val();    // 검색어

    // 실제 backend에 /api/search 요청해서 데이터 가져오기(ajax)
    $.get(`/api/search?searchQuery=${query}`, function(response) {
        console.log('search response값', response);
    });
});