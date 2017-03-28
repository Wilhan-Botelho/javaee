package com.javaee.wilhanbotelho;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.invoke.empty.Empty;

@WebServlet("/pessoa")
public class PessoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public PessoaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q = request.getParameter("q");
		int id = 0;
		if(request.getParameter("id") != null && request.getParameter("id") != ""){
			id = Integer.parseInt(request.getParameter("id"));
		};
		switch (q) {
	        case "editar":
	        	if(id != 0){
					PessoaModel pessoa = new PessoaModel();
					//String nome = request.getParameter("nome");
					//String email = request.getParameter("email");
					//pessoa.setId(2);
					//pessoa.setNome( "Editado" );
					//pessoa.setEmail( email );
					//pessoa.setAtivo(true);
					//pessoa.Salva();
					pessoa = pessoa.Busca(id);
					request.setAttribute("pessoa", pessoa);
					getServletContext().getRequestDispatcher("/PessoaViewCadastro.jsp").forward(request, response);
				}
	            break;
	        case "excluir":
	        	if(id != 0){
					PessoaModel pessoa = new PessoaModel();
					pessoa = pessoa.Deleta(id);
					request.setAttribute("pessoaexcluida", pessoa);
					PessoaModel Pessoas = new PessoaModel();
					List<PessoaModel> lista = Pessoas.BuscaTodos();
					request.setAttribute("listapessoa", lista);
					getServletContext().getRequestDispatcher("/PessoaViewLista.jsp").forward(request, response);
				}
	            break;
	        case "novo":
	        	PessoaModel pessoa = new PessoaModel();
				pessoa.setNome( "" );
				pessoa.setEmail( "" );
				pessoa.setAtivo(true);
				request.setAttribute("pessoa", pessoa);
				getServletContext().getRequestDispatcher("/PessoaViewCadastro.jsp").forward(request, response);	
	            break;
	        default:
	        	PessoaModel Pessoas = new PessoaModel();
				List<PessoaModel> lista = Pessoas.BuscaTodos();
				request.setAttribute("listapessoa", lista);
				getServletContext().getRequestDispatcher("/PessoaViewLista.jsp").forward(request, response);
	            break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PessoaModel pessoa = new PessoaModel();
		int id = 0;
		if(request.getParameter("id") != null && request.getParameter("id") != ""){
			id = Integer.parseInt(request.getParameter("id"));
		};
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		boolean ativo = Boolean.parseBoolean(request.getParameter("ativo"));
		pessoa.setId(id);
		pessoa.setNome( nome );
		pessoa.setEmail( email );
		pessoa.setAtivo( ativo );
		pessoa.Salva();
		PessoaModel Pessoas = new PessoaModel();
		List<PessoaModel> lista = Pessoas.BuscaTodos();
		request.setAttribute("pessoaalterada", pessoa);
		request.setAttribute("listapessoa", lista);
		getServletContext().getRequestDispatcher("/PessoaViewLista.jsp").forward(request, response);
	}
}
