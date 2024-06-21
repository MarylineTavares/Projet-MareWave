import './LearnMore.css'

function LearnMore(){
    return(
        <div class="container-learn-more">
            <button class="learn-more">
                <span class="circle" aria-hidden="true">
                <span class="icon arrow"></span>
                </span>
                <span class="button-text">Voir plus</span>
            </button>
        </div>
    );
}

export default LearnMore;