// json js오브젝트키와 벨류로 구성

//데이터를 읽어봐서 전달해줌 프로미스를 리턴하도록 만듬
//main
// json 파일로 동적으로 받아옴
function lodeItems() {
  return (
    fetch("data/data.json")
      //브라우저 아이템중 하나
      // 파라미터에 경로나 url 네트워크를 통해서 가져옴
      .then((response) => response.json())
      .then((json) => json.items) //배열로 들어왔음 제이슨에 아이템만 가지고 올꺼임
  );
}

function displayItems(items){
    // items을 받아온 요소를 페이지에 나타나도록 만드는 함수
    // 컨테이너 안에 보여줄꺼라서 상수로 잡고 계속 사용함
    const container =document.querySelector(".items");
 //컨네이너 안에 이너html을 생성할껀데= 다음과 같다 
 //1가지의 배열에서 다른 배열형태로 변환 "맵핑" 맵을 이용함
 //item=li태그임 
 //createHTMLString=만들꺼야 html문자열로 변환
 //쏙았다! 내가 만든 함수 였음 
 container.innerHTML=items.map(item=> createHTMLString(item));

}
//각배열의 아이템을 받아와서 li태그로 만들어줌 
function createHTMLString(item){
  
  //여기에 스트링태그를 직접넣어서 만듬!
  
  return `
    <li class="item">
      <img src="${}img/blue_t.png" alt="tshirt" class="item_list" />
      <span class="item_text">male, large</span>
    </li>
  `;

}

lodeItems()
  .then((items) => {
    console.log(items);
    // displayItems(items); //html아이템을 보여주고
    // setEventListeners(items); //이벤트리스너를 등록하여 필터링하는 함수
  })
  .catch(console.log);
