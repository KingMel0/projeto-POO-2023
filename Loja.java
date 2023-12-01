import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Loja {
    private static final String URL = "jdbc:sqlite:loja.db";

    public static void criarTabelas() {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {

            String sqlClientes = "CREATE TABLE IF NOT EXISTS clientes (id INTEGER PRIMARY KEY, nome TEXT, cpf TEXT)";
            statement.execute(sqlClientes);

            String sqlEstoque = "CREATE TABLE IF NOT EXISTS estoque (id INTEGER PRIMARY KEY, marca TEXT, tamanho INTEGER, preco REAL)";
            statement.execute(sqlEstoque);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void adicionarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, cpf) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.executeUpdate();

            System.out.println("Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Cliente> consultarClientes() {
        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM clientes";

        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");

                Cliente cliente = new Cliente(nome, cpf);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public static void adicionarSapato(Sapato sapato) {
        String sql = "INSERT INTO estoque (marca, tamanho, preco) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, sapato.getMarca());
            preparedStatement.setInt(2, sapato.getTamanho());
            preparedStatement.setDouble(3, sapato.getPreco());
            preparedStatement.executeUpdate();

            System.out.println("Sapato adicionado ao estoque com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Sapato> consultarSapatos() {
        List<Sapato> sapatos = new ArrayList<>();

        String sql = "SELECT * FROM estoque";

        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String marca = resultSet.getString("marca");
                int tamanho = resultSet.getInt("tamanho");
                double preco = resultSet.getDouble("preco");

                Sapato sapato = new Sapato(marca, tamanho, preco);
                sapatos.add(sapato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sapatos;
    }
}
