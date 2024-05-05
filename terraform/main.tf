resource "azurerm_resource_group" "my_resource_group" {
  name     = "microviewRG"
  location = " West Europe"
}

resource "azurerm_kubernetes_cluster" "my_aks_cluster" {
  name                = "microview"
  location            = azurerm_resource_group.my_resource_group.location
  resource_group_name = azurerm_resource_group.my_resource_group.name
  dns_prefix          = "myaksdns"
  default_node_pool {
    name       = "default"
    node_count = 1
    vm_size    = "D4s_v3"
  }

  identity {
    type = "SystemAssigned"
  }
}