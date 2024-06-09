[#ftl]
[@c.page]
    <div class="detail">
        <div class="vizitka">
            <div class="jmeno">${vizitka.celeJmeno}</div>
            <div class="firma">${vizitka.firma}</div>
            <div class="udaje">
                <div class="adresa">
                    <div>${vizitka.ulice}</div>
                    <div>${vizitka.psc}</div>
                </div>
                <div class="kontakty">
                    <div><i class="bi bi-at"></i> ${vizitka.email!}</div>
                    <div><i class="bi bi-phone"></i> ${vizitka.telefon!}</div>
                    <div><i class="bi bi-globe"></i> ${vizitka.web!}</div>
                </div>
            </div>
        </div>

        <div class="mapa">
            <iframe style="border:none" src="https://frame.mapy.cz/?q=${vizitka.celaAdresa}" width="100%" height="100%" frameborder="0"></iframe>
        </div>
    </div>
    [@c.back /]

[/@c.page]
