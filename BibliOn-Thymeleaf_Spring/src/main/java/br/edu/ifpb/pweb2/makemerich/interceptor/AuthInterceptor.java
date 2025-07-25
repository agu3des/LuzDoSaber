package br.edu.ifpb.pweb2.makemerich.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.pweb2.makemerich.model.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession httpSession = request.getSession(false);
        if (httpSession != null) {
            Usuario usuario = (Usuario) httpSession.getAttribute("usuario");

            if (usuario != null) {
                String contextPath = request.getContextPath(); 
                String path = request.getRequestURI();

                // Remove o contextPath do path
                String relativePath = path.substring(contextPath.length());

                // Verifica se a URL acessada começa com "/usuarios" ou "/listas"
                boolean requerAdmin = (
                    relativePath.startsWith("/usuarios")  ||
                     (relativePath.startsWith("/listas") &&
                        !(relativePath.equals("/listas") || // GET listagem, já filtrada no controller por tipo
                        relativePath.equals("/listas/form") || // liberar criação de lista
                        relativePath.contains("/nulista") ||
                        relativePath.contains("/transacoes") ||
                        relativePath.contains("/operacao"))) // ← libera o acesso à /listas/operacao
                );

                // Se exige admin, verifica se o usuário é admin
                if (requerAdmin && !usuario.isAdmin()) {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "Acesso negado.");
                    return false;
                }

                // Está logado e tem permissão
                return true;
            }
        }

        // Sem sessão ou usuário não autenticado
        String baseUrl = request.getContextPath();
        response.sendRedirect(response.encodeRedirectURL(baseUrl + "/auth"));
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // Sem uso
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // Sem uso
    }
}