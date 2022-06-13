package com.voitenko.dev.galleryspace

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Parcelize
data class Art(
    val id: String,
    val url: String,
    val title: String,
    val description: String,
    val creator: String,
    val price: String,
    val createdAt: String,
    val proprietors: List<Proprietor>,
) : Parcelable

@Parcelize
data class Proprietor(
    val name: String,
    val url: String,
    val purchase: String,
    val date: String
) : Parcelable

fun mock(id: String) = mock().find { it.id == id }

fun mock() = listOf(
    Art(
        id = "1",
        url ="https://collectionapi.metmuseum.org/api/collection/v1/iiif/591860/1229664/restricted",
        title = "The Treatyse of Fysshynge wyth an Angle from the book of Saint Albans\n1903",
        description = "In 1878 William Loring Andrews became a trustee of The Metropolitan Museum of Art and served as its first librarian. He was a prominent collector of rare books of English and American literature and a founding member of the Grolier Club and the Society of Iconophiles. In 1865 Andrews began to self-publish books in which he was also the author or editor. These works were published in his own taste, through his own direction, and are marked by exquisite taste in type, paper, illustration, and binding. In their production, he engaged the services of engravers Edwin Davis French and S. L. Smith, who designed and engraved bookplates for the Metropolitan Museum, and printers Walter Gillias and Theodore De Vinne. From 1865 to 1908 Andrews issued thirty-six volumes, twenty-six authored by himself. \"The Treatyse of Fysshynge\" was printed on hand-made paper in an edition of 160, at the Gilliss Press; the type, caste specially for the book, was patterned after the traditional Old English characters first used by Wynkyn de Worde. The volume is bound in full limpvellum, with the title gold-tooled on the front cover, and has two green silk ties.",
        creator = "Juliana Berners",
        price = "999 $",
        createdAt = "22 Sep, 67",
        proprietors = listOf()
    ),
    Art(
        id = "2",
        url = "https://collectionapi.metmuseum.org/api/collection/v1/iiif/10499/1660910/main-image",
        title = "The Titan's Goblet\n1833",
        description = "The culmination of Cole's romantic fantasies, this work echoes the artist's other works of the period in its Italian derived scenery and its attempt to illustrate themes dealing with the grandeur of the past, the passage of time, and the encroachment of nature. Rejected by Cole's patron, Luman Reed, and subsequently owned by the artist John M. Falconer, the work defies full explanation. The massive, vegetation encrusted goblet around whose rim are found classical ruins, and on whose glassy surface boats sail, has been linked to Norse legend and Greek mythology. Theophilus Stringfellow, Jr. described it as a self-contained, microcosmic human world in the midst of vast nature, while Falconer linked the monumental stem of the goblet to the trunk of the Norse world-tree; he likened the cup to \"the ramifying branches . . . which spread out and hold between them an ocean dotted with sails, surrounded by dense forests and plains.\" Other theories tie the fantastic forms to J. M. W. Turner's \"Ulysses Deriding Polyphemus\" (National Gallery, London), to Italian architecture and geological formations, or to the golden goblet of the sun-god Helios. The elevation and remove of the cup, rimmed with classical remnants, suggests the disassociation of the present, embodied in the surrounding landscape, from the pinnacle of creation which nourished its culture. Cole serves as intermediary, a role open only to the artist or poet, transcending the strictues of the immediate world to unite past and present.",
        creator = "Thomas Cole",
        price = "1 999 $",
        createdAt = "12 May, 1833",
        proprietors = listOf(
            Proprietor(
                name = "Philip K. Howard",
                url = "https://upload.wikimedia.org/wikipedia/commons/a/ad/Philip_K._Howard.jpg",
                purchase = "1.2224 BTC",
                date = "10.11.2022"
            ),
            Proprietor(
                name = "Alfredo Peters",
                url = "https://miro.medium.com/max/1400/0*E-e0EHOU1Fvxtuis.jpg",
                purchase = "0.0054 BTC",
                date = "16.09.2019"
            ),
            Proprietor(
                name = "Michiel Vernandos",
                url = "https://globalmsk.ru/usr/person/big-person-15642469881.jpg",
                purchase = "127 $",
                date = "26.08.2016"
            ),
            Proprietor(
                name = "Van Gogh",
                url = "https://upload.wikimedia.org/wikipedia/commons/7/76/Vincent_van_Gogh_photo_cropped.jpg",
                purchase = "142 $",
                date = "01.01.2008"
            ),
        )
    ),
    Art(
        id = "3",
        url = "https://collectionapi.metmuseum.org/api/collection/v1/iiif/264711/608595/main-image",
        title = "Black Cañon, From Camp 8, Looking Above\n1871",
        description = "An engineer graduated from West Point, Lieutenant George Wheeler wanted to find inland passage for troops from Idaho and Utah southward to Arizona. In 1871 he was commissioned with the fourth U.S. Survey to map the topography of that region in view of strategic transit and future settlement. To his original corps of scientists Wheeler added the son of a prominent Boston family, to publicize the expedition in the Eastern press, and Timothy O'Sullivan, to provide a visual record.\n" +
                "\n\n" +
                "As O'Sullivan's experience in the field was unequaled from his work as a photographer during the Civil War, it is not surprising that Wheeler placed great confidence in him from the outset, providing him with a roving commission and a boat of his own on the Colorado River. Although Wheeler's boats progressed slowly (they had to be rowed, sailed, and hauled upriver against the current), O'Sullivan's was tardier still. Exploring the astonishing photographic possibilities of the canyons from his boat, \"Picture,\" he meandered, tacked, and stopped as he studied how to turn to advantage the sun and shade, the sheer cliffs, and their reflection in the water and profile against the sky.\n" +
                "\n\n" +
                "Individually, the Black Canyon photographs have exquisite resolution. In sequence, they constitute the pictorial voyage of a reflective, visionary artist who knew how to orchestrate his experience of place. As one turns the pages of the album, the shifting perspectives of river and cliff move in stately progression as, effectively as a diorama, they carry the viewer deep into the very heart of the canyon, where, Wheeler wrote, \"a stillness like death creates impressions of awe.\"\n" +
                "\n\n" +
                "This photograph appears in an album of thirty-five photographs by O'Sullivan entitled \"Photographs Showing Landscapes, Geological and Other Features of Portions of the Western Territory of the United States Obtained in Connection with Geographical and Geological Explorations and Surveys West of the 100th Meridian. Season of 1871.\"",
        creator = "Timothy H. O'Sullivan",
        price = "9 000 $",
        createdAt = "01 June, 1871",
        proprietors = listOf(
            Proprietor(
                name = "Philip K. Howard",
                url = "https://upload.wikimedia.org/wikipedia/commons/a/ad/Philip_K._Howard.jpg",
                purchase = "1.2224 BTC",
                date = "10.11.2022"
            ),
            Proprietor(
                name = "Alfredo Peters",
                url = "https://miro.medium.com/max/1400/0*E-e0EHOU1Fvxtuis.jpg",
                purchase = "0.0054 BTC",
                date = "16.09.2019"
            ),
            Proprietor(
                name = "Michiel Vernandos",
                url = "https://globalmsk.ru/usr/person/big-person-15642469881.jpg",
                purchase = "127 $",
                date = "26.08.2016"
            ),
            Proprietor(
                name = "Van Gogh",
                url = "https://upload.wikimedia.org/wikipedia/commons/7/76/Vincent_van_Gogh_photo_cropped.jpg",
                purchase = "142 $",
                date = "01.01.2008"
            ),
        )
    ),
    Art(
        id = "4",
        url = "https://collectionapi.metmuseum.org/api/collection/v1/iiif/339671/763635/main-image",
        title = "Armor\n1891",
        description = "This fantastical drawing of a helmeted woman in profile is one of four similar charcoal drawings Redon executed during the last decade of the nineteenth century. The sitter, rendered strangely mute by her helmetlike covering and untouchable by its thorny needles, varies slightly from sheet to sheet. While the exact meaning of Redon's image is unclear, it has been thought that the bizarre bondage imposed on his sitter expresses subconscious fear of female sexuality or, conversely, serves as a symbol of female fecundity. Equally important, however, is Redon's virtuoso handling of charcoal and his ability to capture its full range of tones, from the dark velvet quality of the helmet to the pallor of the woman's skin.",
        creator = "Odilon Redon",
        price = "199 $",
        createdAt = "19 May, 1891",
        proprietors = listOf(
            Proprietor(
                name = "Philip K. Howard",
                url = "https://upload.wikimedia.org/wikipedia/commons/a/ad/Philip_K._Howard.jpg",
                purchase = "1.2224 BTC",
                date = "10.11.2022"
            ),
            Proprietor(
                name = "Alfredo Peters",
                url = "https://miro.medium.com/max/1400/0*E-e0EHOU1Fvxtuis.jpg",
                purchase = "0.0054 BTC",
                date = "16.09.2019"
            ),
            Proprietor(
                name = "Michiel Vernandos",
                url = "https://globalmsk.ru/usr/person/big-person-15642469881.jpg",
                purchase = "127 $",
                date = "26.08.2016"
            ),
            Proprietor(
                name = "Van Gogh",
                url = "https://upload.wikimedia.org/wikipedia/commons/7/76/Vincent_van_Gogh_photo_cropped.jpg",
                purchase = "142 $",
                date = "01.01.2008"
            ),
        )
    ),
    Art(
        id = "5",
        url = "https://collectionapi.metmuseum.org/api/collection/v1/iiif/436603/796433/main-image",
        title = "Samson Captured by the Philistines\n1619",
        description = "According to the Bible, Samson, whose strength came from his hair, was shorn by his duplicitous lover, Delilah, and then set upon by the Philistines, who bound and blinded him. The focus of this dramatic and marvelously staged composition—a landmark in the artist’s career—is the vigorously modeled back of Samson, struggling to free himself. It is one of several commissions from Cardinal Giacomo Serra, the papal legate to Ferrara. Serra was a notable collector in Rome and also promoted Rubens.",
        creator = "Guercino (Giovanni Francesco Barbieri)",
        price = "1200 $",
        createdAt = "08 Apr, 1619",
        proprietors = listOf(
            Proprietor(
                name = "Philip K. Howard",
                url = "https://upload.wikimedia.org/wikipedia/commons/a/ad/Philip_K._Howard.jpg",
                purchase = "1.2224 BTC",
                date = "10.11.2022"
            ),
            Proprietor(
                name = "Alfredo Peters",
                url = "https://miro.medium.com/max/1400/0*E-e0EHOU1Fvxtuis.jpg",
                purchase = "0.0054 BTC",
                date = "16.09.2019"
            ),
            Proprietor(
                name = "Michiel Vernandos",
                url = "https://globalmsk.ru/usr/person/big-person-15642469881.jpg",
                purchase = "127 $",
                date = "26.08.2016"
            ),
            Proprietor(
                name = "Van Gogh",
                url = "https://upload.wikimedia.org/wikipedia/commons/7/76/Vincent_van_Gogh_photo_cropped.jpg",
                purchase = "142 $",
                date = "01.01.2008"
            ),
        )
    )
)
