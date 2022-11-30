// console.log("this is script file");

// const toggleSidebar = () => {
//     if($(".sidebar").is(":visible")){

//         $(".sidebar").css("display","none");
//         $(".content").css("margin-left","0%");
//     }
//     else 
//     {
//         $(".sidebar").css("display","block");
//         $(".content").css("margin-left","20%");
//     }
// }

function closeNav() {
    document.getElementsByClassName("sidebar")[0].style.display = "none";
    document.getElementsByClassName("content")[0].style.marginLeft = "1%";
    document.getElementsByClassName("hambergurgers")[0].style.display = "inline";
}

function openNav() {
    document.getElementsByClassName("sidebar")[0].style.display = "block";
    document.getElementsByClassName("content")[0].style.marginLeft = "0";
}


// var cross= 1;
// let selectId=document.getElementsByClassName("cross1");
// function closeNav(){
//     if(cross == 1){
//        selectId[0].classList.remove("sidebar");
//        selectId[0].classList.add("HiddenContent");
//         cross=0;
//     }
//     // else
//     // {
//     //     // selectId[0].classList.remove("HiddenContent");
//     //    selectId[0].classList.add("sidebar");
//     //     cross=1;
//     // }
// }


fetch("http://localhost:8080/showContact").then((data)=>{
    // console.log(data);
    return data.json();
}).then((objectData)=>{
    // console.log(objectData[0].name);
    let tableData="";
    objectData.map((values)=>{
    tableData +=` <tr>
    <th scope="row">${values.id}</th>
    <td>${values.name}</td>
    <td>${values.email}</td>
    <td>${values.mobile_number}</td>
    <td>${values.work}</td>
    <td><a href="updateContact.html" <i class="fa-solid pen fa-pen"></i></a> <a href="deleteContact.html" <i class="fa-sharp fa-solid fa-trash"></i></a> </td>
  </tr>`;
    })
    document.getElementById("table_body").innerHTML=tableData;
}).catch((err)=>{
    console.log(err);
})



