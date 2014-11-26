package org.sagebionetworks.bridge.scripts;

import java.util.LinkedList;

import org.sagebionetworks.bridge.sdk.models.surveys.SurveyQuestionOption;

@SuppressWarnings("serial")
public class CountryOfResidenceList extends LinkedList<SurveyQuestionOption> {

    private void addCountry(String name, String code) {
        add(new SurveyQuestionOption(name, code));
    }
    
    public CountryOfResidenceList() {
        /*
        addCountry("Afghanistan","AFG");
        addCountry("Åland Islands","ALA");
        addCountry("Albania","ALB");
        addCountry("Algeria","DZA");
        addCountry("American Samoa","ASM");
        addCountry("Andorra","AND");
        addCountry("Angola","AGO");
        addCountry("Anguilla","AIA");
        addCountry("Antarctica","ATA");
        addCountry("Antigua and Barbuda","ATG");
        addCountry("Argentina","ARG");
        addCountry("Armenia","ARM");
        addCountry("Aruba","ABW");
        addCountry("Australia","AUS");
        addCountry("Austria","AUT");
        addCountry("Azerbaijan","AZE");
        addCountry("Bahamas","BHS");
        addCountry("Bahrain","BHR");
        addCountry("Bangladesh","BGD");
        addCountry("Barbados","BRB");
        addCountry("Belarus","BLR");
        addCountry("Belgium","BEL");
        addCountry("Belize","BLZ");
        addCountry("Benin","BEN");
        addCountry("Bermuda","BMU");
        addCountry("Bhutan","BTN");
        addCountry("Bolivia, Plurinational State of","BOL");
        addCountry("Bonaire, Sint Eustatius and Saba","BES");
        addCountry("Bosnia and Herzegovina","BIH");
        addCountry("Botswana","BWA");
        addCountry("Bouvet Island","BVT");
        addCountry("Brazil","BRA");
        addCountry("British Indian Ocean Territory","IOT");
        addCountry("Brunei Darussalam","BRN");
        addCountry("Bulgaria","BGR");
        addCountry("Burkina Faso","BFA");
        addCountry("Burundi","BDI");
        addCountry("Cambodia","KHM");
        addCountry("Cameroon","CMR");
        addCountry("Canada","CAN");
        addCountry("Cabo Verde","CPV");
        addCountry("Cayman Islands","CYM");
        addCountry("Central African Republic","CAF");
        addCountry("Chad","TCD");
        addCountry("Chile","CHL");
        addCountry("China","CHN");
        addCountry("Christmas Island","CXR");
        addCountry("Cocos (Keeling) Islands","CCK");
        addCountry("Colombia","COL");
        addCountry("Comoros","COM");
        addCountry("Congo","COG");
        addCountry("Congo, the Democratic Republic of the","COD");
        addCountry("Cook Islands","COK");
        addCountry("Costa Rica","CRI");
        addCountry("Côte d'Ivoire","CIV");
        addCountry("Croatia","HRV");
        addCountry("Cuba","CUB");
        addCountry("Curaçao","CUW");
        addCountry("Cyprus","CYP");
        addCountry("Czech Republic","CZE");
        addCountry("Denmark","DNK");
        addCountry("Djibouti","DJI");
        addCountry("Dominica","DMA");
        addCountry("Dominican Republic","DOM");
        addCountry("Ecuador","ECU");
        addCountry("Egypt","EGY");
        addCountry("El Salvador","SLV");
        addCountry("Equatorial Guinea","GNQ");
        addCountry("Eritrea","ERI");
        addCountry("Estonia","EST");
        addCountry("Ethiopia","ETH");
        addCountry("Falkland Islands (Malvinas)","FLK");
        addCountry("Faroe Islands","FRO");
        addCountry("Fiji","FJI");
        addCountry("Finland","FIN");
        addCountry("France","FRA");
        addCountry("French Guiana","GUF");
        addCountry("French Polynesia","PYF");
        addCountry("French Southern Territories","ATF");
        addCountry("Gabon","GAB");
        addCountry("Gambia","GMB");
        addCountry("Georgia","GEO");
        addCountry("Germany","DEU");
        addCountry("Ghana","GHA");
        addCountry("Gibraltar","GIB");
        addCountry("Greece","GRC");
        addCountry("Greenland","GRL");
        addCountry("Grenada","GRD");
        addCountry("Guadeloupe","GLP");
        addCountry("Guam","GUM");
        addCountry("Guatemala","GTM");
        addCountry("Guernsey","GGY");
        addCountry("Guinea","GIN");
        addCountry("Guinea-Bissau","GNB");
        addCountry("Guyana","GUY");
        addCountry("Haiti","HTI");
        addCountry("Heard Island and McDonald Islands","HMD");
        addCountry("Holy See (Vatican City State)","VAT");
        addCountry("Honduras","HND");
        addCountry("Hong Kong","HKG");
        addCountry("Hungary","HUN");
        addCountry("Iceland","ISL");
        addCountry("India","IND");
        addCountry("Indonesia","IDN");
        addCountry("Iran, Islamic Republic of","IRN");
        addCountry("Iraq","IRQ");
        addCountry("Ireland","IRL");
        addCountry("Isle of Man","IMN");
        addCountry("Israel","ISR");
        addCountry("Italy","ITA");
        addCountry("Jamaica","JAM");
        addCountry("Japan","JPN");
        addCountry("Jersey","JEY");
        addCountry("Jordan","JOR");
        addCountry("Kazakhstan","KAZ");
        addCountry("Kenya","KEN");
        addCountry("Kiribati","KIR");
        addCountry("Korea, Democratic People's Republic of","PRK");
        addCountry("Korea, Republic of","KOR");
        addCountry("Kuwait","KWT");
        addCountry("Kyrgyzstan","KGZ");
        addCountry("Lao People's Democratic Republic","LAO");
        addCountry("Latvia","LVA");
        addCountry("Lebanon","LBN");
        addCountry("Lesotho","LSO");
        addCountry("Liberia","LBR");
        addCountry("Libya","LBY");
        addCountry("Liechtenstein","LIE");
        addCountry("Lithuania","LTU");
        addCountry("Luxembourg","LUX");
        addCountry("Macao","MAC");
        addCountry("Macedonia, the former Yugoslav Republic of","MKD");
        addCountry("Madagascar","MDG");
        addCountry("Malawi","MWI");
        addCountry("Malaysia","MYS");
        addCountry("Maldives","MDV");
        addCountry("Mali","MLI");
        addCountry("Malta","MLT");
        addCountry("Marshall Islands","MHL");
        addCountry("Martinique","MTQ");
        addCountry("Mauritania","MRT");
        addCountry("Mauritius","MUS");
        addCountry("Mayotte","MYT");
        addCountry("Mexico","MEX");
        addCountry("Micronesia, Federated States of","FSM");
        addCountry("Moldova, Republic of","MDA");
        addCountry("Monaco","MCO");
        addCountry("Mongolia","MNG");
        addCountry("Montenegro","MNE");
        addCountry("Montserrat","MSR");
        addCountry("Morocco","MAR");
        addCountry("Mozambique","MOZ");
        addCountry("Myanmar","MMR");
        addCountry("Namibia","NAM");
        addCountry("Nauru","NRU");
        addCountry("Nepal","NPL");
        addCountry("Netherlands","NLD");
        addCountry("New Caledonia","NCL");
        addCountry("New Zealand","NZL");
        addCountry("Nicaragua","NIC");
        addCountry("Niger","NER");
        addCountry("Nigeria","NGA");
        addCountry("Niue","NIU");
        addCountry("Norfolk Island","NFK");
        addCountry("Northern Mariana Islands","MNP");
        addCountry("Norway","NOR");
        addCountry("Oman","OMN");
        addCountry("Pakistan","PAK");
        addCountry("Palau","PLW");
        addCountry("Palestine, State of","PSE");
        addCountry("Panama","PAN");
        addCountry("Papua New Guinea","PNG");
        addCountry("Paraguay","PRY");
        addCountry("Peru","PER");
        addCountry("Philippines","PHL");
        addCountry("Pitcairn","PCN");
        addCountry("Poland","POL");
        addCountry("Portugal","PRT");
        addCountry("Puerto Rico","PRI");
        addCountry("Qatar","QAT");
        addCountry("Réunion","REU");
        addCountry("Romania","ROU");
        addCountry("Russian Federation","RUS");
        addCountry("Rwanda","RWA");
        addCountry("Saint Barthélemy","BLM");
        addCountry("Saint Helena, Ascension and Tristan da Cunha","SHN");
        addCountry("Saint Kitts and Nevis","KNA");
        addCountry("Saint Lucia","LCA");
        addCountry("Saint Martin (French part)","MAF");
        addCountry("Saint Pierre and Miquelon","SPM");
        addCountry("Saint Vincent and the Grenadines","VCT");
        addCountry("Samoa","WSM");
        addCountry("San Marino","SMR");
        addCountry("Sao Tome and Principe","STP");
        addCountry("Saudi Arabia","SAU");
        addCountry("Senegal","SEN");
        addCountry("Serbia","SRB");
        addCountry("Seychelles","SYC");
        addCountry("Sierra Leone","SLE");
        addCountry("Singapore","SGP");
        addCountry("Sint Maarten (Dutch part)","SXM");
        addCountry("Slovakia","SVK");
        addCountry("Slovenia","SVN");
        addCountry("Solomon Islands","SLB");
        addCountry("Somalia","SOM");
        addCountry("South Africa","ZAF");
        addCountry("South Georgia and the South Sandwich Islands","SGS");
        addCountry("South Sudan","SSD");
        addCountry("Spain","ESP");
        addCountry("Sri Lanka","LKA");
        addCountry("Sudan","SDN");
        addCountry("Suriname","SUR");
        addCountry("Svalbard and Jan Mayen","SJM");
        addCountry("Swaziland","SWZ");
        addCountry("Sweden","SWE");
        addCountry("Switzerland","CHE");
        addCountry("Syrian Arab Republic","SYR");
        addCountry("Taiwan, Province of China","TWN");
        addCountry("Tajikistan","TJK");
        addCountry("Tanzania, United Republic of","TZA");
        addCountry("Thailand","THA");
        addCountry("Timor-Leste","TLS");
        addCountry("Togo","TGO");
        addCountry("Tokelau","TKL");
        addCountry("Tonga","TON");
        addCountry("Trinidad and Tobago","TTO");
        addCountry("Tunisia","TUN");
        addCountry("Turkey","TUR");
        addCountry("Turkmenistan","TKM");
        addCountry("Turks and Caicos Islands","TCA");
        addCountry("Tuvalu","TUV");
        addCountry("Uganda","UGA");
        addCountry("Ukraine","UKR");
        addCountry("United Arab Emirates","ARE");
        */
        addCountry("United Kingdom","GBR");
        addCountry("United States","USA");
        /*
        addCountry("United States Minor Outlying Islands","UMI");
        addCountry("Uruguay","URY");
        addCountry("Uzbekistan","UZB");
        addCountry("Vanuatu","VUT");
        addCountry("Venezuela, Bolivarian Republic of","VEN");
        addCountry("Viet Nam","VNM");
        addCountry("Virgin Islands, British","VGB");
        addCountry("Virgin Islands, U.S.","VIR");
        addCountry("Wallis and Futuna","WLF");
        addCountry("Western Sahara","ESH");
        addCountry("Yemen","YEM");
        addCountry("Zambia","ZMB");
        addCountry("Zimbabwe","ZWE");
        */
    }
}
