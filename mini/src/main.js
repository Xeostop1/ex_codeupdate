// json js오브젝트키와 벨류로 구성

//데이터를 읽어봐서 전달해줌 프로미스를 리턴하도록 만듬
//main


// json 파일로 동적으로 받아옴
async function loadItems() {
  const response = await fetch('data/data.json');
  const json = await response.json();
  return json.items; //배열로 들어왔음 제이슨에 아이템만 가지고 올꺼임
}


// html 아이템 동적 생성
function displayItems(items){
    // items을 받아온 요소를 페이지에 나타나도록 만드는 함수
    // 컨테이너 안에 보여줄꺼라서 상수로 잡고 계속 사용함
    const container =document.querySelector('.items');
 //컨네이너 안에 이너html을 생성할껀데= 다음과 같다 
 //1가지의 배열에서 다른 배열형태로 변환 "맵핑" 맵을 이용함
 //item=li태그임 
 //createHTMLString=만들꺼야 html문자열로 변환
 //쏙았다! 내가 만든 함수 였음 
 const html=items.map(items=> createHTMLString(item));
 container.innerHTML=items.map(item=> createHTMLString(item)).join('');
 // 이걸 풀어서 쓰면 join 어렵네
//  console.log(html);
//  container.innerHTML=items.map(item=>createHTMLString(item).join(''));

}
//각배열의 아이템을 받아와서 li태그로 만들어줌 
//태그에 없어도 동적으로 태그를 생성해서 만들어줌 
function createHTMLString(item){
  
  //여기에 스트링태그를 직접넣어서 만듬!
  

  
  return `
    <li class="item">
      <img src="${item.image}" alt="${item.type}" class="item_list" />
      <span class="item_text">${item.gender}, ${item.size}</span>
    </li>
  `;
}
//맵에서 문자열 병합하는Api join

loadItems()
  .then((items) => {
    // console.log(items);
    // displayItems(items); //html아이템을 보여주고
    // setEventListeners(items); //이벤트리스너를 등록하여 필터링하는 함수
  })
  // .catch(console.log);
