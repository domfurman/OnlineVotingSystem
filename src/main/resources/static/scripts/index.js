// function getAllVotings() {
//     return fetch('/votings/Election1')
//         .then(response => response.json())
//         .then(vote => vote.voteUUID)
// }
function createContent(voting) {
    let elem = document.createElement("div");
    elem.innerHTML = `
    <h1>${voting.voteName}</h1>
    <h3>Votes for: ${voting.votesFor}</h3>
    <h3>Votes against: ${voting.votesAgainst}</h3>
    <h4>You can vote until ${voting.validityDate}</h4>
    `;
    let parentElem = document.querySelector("#testowy");
    parentElem.appendChild(elem);
}

async function getAllVotings() {
    const response = await fetch('/votings');
    const vote = await response.json();
    return vote;
}

(async () => {
    const votings = await getAllVotings();
    votings.map(voting => createContent(voting));
})();
// const ul = document.getElementById('votings-list');
// const list = document.createDocumentFragment();
// fetch("/votings")
//     .then(response => {
//         return response.json()
//     }).then((data) => {
//         let votings = data;
//
//         votings.map(function (voting) {
//             let li = document.createElement('li');
//             let name = document.createElement('h2');
//
//             name.innerHTML = `sprawdzmy to!`;
//             li.appendChild(name);
//             list.appendChild(li)
//         });
// }).catch(function (error) {
//     console.log(error)
// });
// ul.appendChild(list);


// const createHtmlFromString = (htmlAsString) => {
//     let tmpElem = document.createElement('div');
//     tmpElem.innerHTML = htmlAsString.trim();
//     return tmpElem.firstChild;
// }
//
// const createHtmlComponent = (voting) => {
//     const template = `
//     <li class="voting">
//         <h2>Voting1</h2>
//     </li>
//     `;
//     return createHtmlFromString(template);
// }
// const createHtmlComponent2 = () => {
//     const template = `
//     <p>Klasa!</p>
//     `;
//     return createHtmlFromString(template);
// }

// const initializeAddToCartHandler = (htmlEl) => {
//     const btn = htmlEl.querySelector('button.btn1');
//     btn.addEventListener('click', () => {
//         console.log("maybe working");
//     });
//     return htmlEl;
// };

// (async () => {
    // const votingListEl = document.querySelector('#votings-list')
    // const votings = await getAllVotings();
    // votings.map(voting => createHtmlComponent2()).forEach(el => votingListEl.appendChild(el))
    // const divy = document.querySelector('#testowy')
    // divy.appendChild(createHtmlComponent2())

// })();