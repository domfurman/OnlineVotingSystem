async function getAllVotings() {
    const response = await fetch('/api/votings');
    const vote = await response.json();
    return vote;
}

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



(async () => {
    const votings = await getAllVotings();
    votings.map(voting => createContent(voting));
})();
