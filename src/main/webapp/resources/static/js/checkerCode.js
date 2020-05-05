function f(Object) {

    console.log(Object);
    $('#codeComp').append("<table class='table table-hover table-dark'>" +
        "<thead>" +
        "    <tr>" +
        "      <th scope=\"col\">Score</th>" +
        "      <th scope=\"col\">Original</th>" +
        "      <th scope=\"col\">Plagiarism</th>" +
        "    </tr>" +
        "  </thead>" +
        "<tbody id='table'>" +
        "</tbody>" +
        "</table>"
    );
    for (let i = 0; i < Object.base_codes_plagiarism_matches.length; i++) {
        if (Object.similarity_coefficients[i] !== 0) {
            $("#table").append("<tr>" +
                "<th scope=\"row\">" + Object.similarity_coefficients[i].toFixed(2) * 100 + "%</th>" +
                "<td></td>" +
                "<td></td>");

            for (let j = 0; j < Object.base_codes_plagiarism_matches[i].length; j++) {

                $('tr').last().find('td')[0].innerHTML += "<pre><code>" +
                    js_beautify(Object.base_codes_plagiarism_matches[i][j])

                    + "</code></pre>";
                $('tr').last().find('td')[1].innerHTML += "<pre><code>" +
                    js_beautify(Object.code_to_check_plagiarism_matches[i][j])
                    + "</code></pre>";

            }

        }

    }

}
