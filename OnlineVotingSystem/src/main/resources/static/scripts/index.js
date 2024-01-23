async function getAllVotings() {
    const response = await fetch('/api/votings');
    const vote = await response.json();
    return vote;
}

const createContent = (voting) => {
    let elem = document.createElement("div");
    elem.innerHTML = `
    <h1>${voting.voteName}</h1>
    <h3>Votes for: ${voting.votesFor}</h3>
    <h3>Votes against: ${voting.votesAgainst}</h3>
    <h4>You can vote until ${voting.validityDate}</h4>
    <button class="voting__vote_for" data-voting-uuid="${voting.voteUUID}">Vote FOR</button>
    `;
    let parentElem = document.querySelector("#testowy");
    parentElem.appendChild(elem);
}

// const createVotingButton = (voting) => {
//     let btnElem = document.createElement("div");
//     btnElem.innerHTML = `
//         <button
//             class="btn__vote_for"
//             data-voting-id="${voting.voteName}"
//         >
//             Vote!
//         </button>
//     `;
//     let parentElem = document.querySelector('#btndiv');
//     parentElem.appendChild(btnElem);
// }

const vote = (votingUUID) => {
    return fetch(`/api/votings/vote_for/${votingUUID}`, {
        method: 'PUT'
    });
}

const initializeVotingHandler = (c) => {
    const btn = document.getElementsByClassName('voting__vote_for');
    btn[0].addEventListener('click', () => {
        vote(btn[0].getAttribute('data-voting-id'));
    });
    console.log(btn)
    // return htmlElement
}

(async () => {
    const votings = await getAllVotings();
    votings
        .map(voting => createContent(voting))
        // .map(b => createVotingButton(b))
        .map(c => initializeVotingHandler(c))
        ;
})();
